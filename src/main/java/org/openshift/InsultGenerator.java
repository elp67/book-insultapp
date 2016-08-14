package org.openshift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsultGenerator {
  public String generateInsult() {
    String vowels = "AEIOU";
    String article = "an";
    String theInsult = "";

    try {
      String databaseURL = "jdbc:postgresql://";
      databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
      databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
      String username = System.getenv("POSTGRESQL_USER");
      String password = System.getent("PGPASSWORD");
      Connection connection = DriverManager.getConnection(databaseURL, username, password);

      if (connection != null) {
        String SQL = "select a.string AS first, b.string AS second, c.string AS noun
          from short_adjective a, long adjective b, noun c ORDER BY random() limit 1";
