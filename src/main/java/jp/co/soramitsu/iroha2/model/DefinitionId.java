package jp.co.soramitsu.iroha2.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class DefinitionId implements IdBox {

    @NonNull
    private String name;
    @NonNull
    private String domainName;

    @Override
    public int getIndex() {
        return 2;
    }
}
