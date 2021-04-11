package jp.co.soramitsu.iroha2.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Or implements Expression {

  // Expression, which should evaluate to `bool`.
  @NonNull
  private Expression left;
  // Expression, which should evaluate to `bool`.
  @NonNull
  private Expression right;


  @Override
  public int getIndex() {
    return 11;
  }
}
