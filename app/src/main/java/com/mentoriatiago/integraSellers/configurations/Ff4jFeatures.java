package com.mentoriatiago.integraSellers.configurations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Ff4jFeatures {

  SEND_TO_BROADCAST(
      "send-sellers-to-broadcast",
      "features",
      "Envia os dados do seller cadastrado para o broadcast do Kafka.",
      true);

  private final String key;
  private final String groupName;
  private final String description;
  private final boolean defaultValue;
}
