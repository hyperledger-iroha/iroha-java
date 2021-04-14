package jp.co.soramitsu.iroha2.model.events;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Responses to event subscription.
 */
@Data
@NoArgsConstructor
public class Event {

  @NonNull
  private EventType eventType;

}
