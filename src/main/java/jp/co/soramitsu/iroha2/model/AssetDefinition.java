package jp.co.soramitsu.iroha2.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class AssetDefinition implements IdentifiableBox {

  @NonNull
  private AssetValue valueType;

  @NonNull
  private DefinitionId id;

  @Override
  public int getIndex() {
    return 3;
  }
}
