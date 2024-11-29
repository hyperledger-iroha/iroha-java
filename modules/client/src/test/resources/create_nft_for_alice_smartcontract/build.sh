#!/bin/bash

cargo +nightly-2024-09-09 build --profile=deploy -Zbuild-std -Zbuild-std-features=panic_immediate_abort
cp ./target/wasm32-unknown-unknown/deploy/create_nft_for_alice_smartcontract.wasm ../create_nft_for_alice_smartcontract.wasm
