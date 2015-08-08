CREATE TABLE player (
  id VARCHAR_IGNORECASE(36) not null,
  first_name VARCHAR(255) not null,
  last_name VARCHAR(255) not null,
  position_name VARCHAR(255) not null,
  injury_status VARCHAR(255),
  salary DOUBLE not null,
  team_id VARCHAR(255) not null,
  updated TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE team (
  id VARCHAR_IGNORECASE(36) not null,
  abbreviation VARCHAR(255) not null,
  updated TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);

ALTER TABLE player ADD FOREIGN KEY (team_id) REFERENCES team(id);

