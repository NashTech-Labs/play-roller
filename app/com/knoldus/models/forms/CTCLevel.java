package com.knoldus.models.forms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CTCLevel {
  private long id;
  private String name;

  public CTCLevel(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static List<String> getNameList() {
    String[] nameArray = { "Fresher", "2 years", "4 years", "6-8 years", "Senior" };
    return Arrays.asList(nameArray);
  }

  public static CTCLevel findLevel(String levelName) {
    for (CTCLevel level : allLevels) {
      if (levelName.equals(level.getName())) {
        return level;
      }
    }
    return null;
  }

  public static CTCLevel getDefaultLevel() {
    return findLevel("Fresher");
  }

  @Override public String toString() {
    return String.format("[CTCLevel %s]", this.name);
  }

  /**
   * Fake a database.
   */
  private static List<CTCLevel> allLevels = new ArrayList<CTCLevel>();

  /** Instantiate the fake database. */
  static {
    allLevels.add(new CTCLevel(1L, "Fresher"));
    allLevels.add(new CTCLevel(2L, "2 years"));
    allLevels.add(new CTCLevel(3L, "4 years"));
    allLevels.add(new CTCLevel(4L, "6-8 years"));
    allLevels.add(new CTCLevel(5L, "Senior"));
  }

}
