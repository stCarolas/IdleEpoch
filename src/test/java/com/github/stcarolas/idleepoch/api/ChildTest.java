package com.github.stcarolas.idleepoch.api;

import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;

public class ChildTest {

  @Test
  public void testSerializingChildAsParent() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(
      ImmutableChild.builder()
        .from(ImmutableAnotherChild.builder().test("testValue").build())
        .build()
    );
    System.out.println(String.format("TESTED: %s", json));
  }
}
