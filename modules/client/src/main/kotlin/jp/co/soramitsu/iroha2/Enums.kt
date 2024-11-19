package jp.co.soramitsu.iroha2

enum class Permissions(val type: String) {
    CanManagePeers("CanManagePeers"),

    CanRegisterDomain("CanRegisterDomain"),
    CanUnregisterDomain("CanUnregisterDomain"),
    CanModifyDomainMetadata("CanModifyDomainMetadata"),

    CanRegisterAccount("CanRegisterAccount"),
    CanUnregisterAccount("CanUnregisterAccount"),
    CanModifyAccountMetadata("CanModifyAccountMetadata"),

    CanRegisterAssetDefinition("CanRegisterAssetDefinition"),
    CanUnregisterAssetDefinition("CanUnregisterAssetDefinition"),
    CanModifyAssetDefinitionMetadata("CanModifyAssetDefinitionMetadata"),

    CanRegisterAssetWithDefinition("CanRegisterAssetWithDefinition"),
    CanUnregisterAssetWithDefinition("CanUnregisterAssetWithDefinition"),
    CanBurnAssetWithDefinition("CanBurnAssetWithDefinition"),
    CanMintAssetWithDefinition("CanMintAssetWithDefinition"),
    CanTransferAssetWithDefinition("CanTransferAssetWithDefinition"),
    CanRegisterAsset("CanRegisterAsset"),
    CanUnregisterAsset("CanUnregisterAsset"),
    CanMintAsset("CanMintAsset"),
    CanBurnAsset("CanBurnAsset"),
    CanTransferAssets("CanTransferAsset"),
    CanModifyAssetMetadata("CanModifyAssetMetadata"),

    CanSetParameters("CanSetParameters"),
    CanManageRoles("CanManageRoles"),

    CanRegisterTrigger("CanRegisterTrigger"),
    CanUnregisterTrigger("CanUnregisterTrigger"),
    CanModifyTrigger("CanModifyTrigger"),
    CanExecuteTrigger("CanExecuteTrigger"),
    CanModifyTriggerMetadata("CanModifyTriggerMetadata"),

    CanUpgradeExecutor("CanUpgradeExecutor"),
}

enum class IdKey(val type: String) {
    AccountId("account"),
    AssetId("asset"),
    AssetDefinitionId("asset_definition"),
    DomainId("domain"),
}
