package com.tsanta.storedint.endpoint;

import com.tsanta.storedint.model.StoredInt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredIntController {
  private final StoredInt storedInt = new StoredInt();

  @GetMapping("/stored-int")
  public String getStoredInt() {
    return storedInt.getStoredInt();
  }
}
