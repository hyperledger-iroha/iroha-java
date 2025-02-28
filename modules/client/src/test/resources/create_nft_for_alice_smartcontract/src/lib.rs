//! Smartcontract which creates new nft for every user
//!
//! This module isn't included in the build-tree,
//! but instead it is being built by a `client/build.rs`
#![no_std]

extern crate alloc;
#[cfg(not(test))]
extern crate panic_halt;

use alloc::{format, string::ToString};
use dlmalloc::GlobalDlmalloc;

#[global_allocator]
static ALLOC: GlobalDlmalloc = GlobalDlmalloc;

use iroha_trigger::prelude::*;

#[iroha_trigger::main]
fn main(host: Iroha, _context: Context) {
    let account_id: AccountId =
        "ed0120CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03@wonderland"
            .parse()
            .unwrap();
    let mut metadata = Metadata::default();
    let name = format!(
        "nft_for_{}_in_{}",
        account_id.signatory(),
        account_id.domain()
    )
    .parse()
    .dbg_unwrap();
    metadata.insert(name, true);

    let nft_id = generate_new_nft_id(&host, &account_id);
    let nft_definition = AssetDefinition::store(nft_id.clone())
        .mintable_once()
        .with_metadata(metadata);

    host.submit(&Register::asset_definition(nft_definition))
        .dbg_unwrap();
    host.submit(&SetKeyValue::asset(
        AssetId::new(nft_id, account_id),
        "has_this_nft".parse::<Name>().dbg_unwrap(),
        true,
    ))
    .dbg_unwrap();
}

fn generate_new_nft_id(host: &Iroha, account_id: &AccountId) -> AssetDefinitionId {
    let assets = host
        .query(FindAssets)
        .filter_with(|asset| asset.id.account.eq(account_id.clone()))
        .execute()
        .dbg_unwrap();

    let new_number = assets
        .into_iter()
        .map(|res| res.dbg_unwrap())
        .filter(|asset| asset.id().definition().to_string().starts_with("nft_"))
        .count()
        .checked_add(1)
        .dbg_unwrap();

    format!(
        "nft_number_{}_for_{}#{}",
        new_number,
        account_id.signatory(),
        account_id.domain()
    )
    .parse()
    .dbg_unwrap()
}
