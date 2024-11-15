INSERT INTO match (id, description, match_date, match_time, team_a, team_b, sport) values (1, 'OSFP-PAO', '2024-10-31', '18:30', 'OSFP', 'PAO', 0)
INSERT INTO match (id, description, match_date, match_time, team_a, team_b, sport) values (2, 'AEK-PAOK', '2024-11-1', '19:30', 'AEK', 'PAOK', 1)

INSERT INTO match_odds (id, match_id, specifier, odds) values (1, 1, 'PAO WIN', 2.5)
INSERT INTO match_odds (id, match_id, specifier, odds) values (2, 1, 'AEK WIN', 3)
INSERT INTO match_odds (id, match_id, specifier, odds) values (3, 1, 'DRAW', 4.56)
INSERT INTO match_odds (id, match_id, specifier, odds) values (4, 2, 'AEK WIN', 3.54)
INSERT INTO match_odds (id, match_id, specifier, odds) values (5, 2, 'PAOK WIN', 3.8)
INSERT INTO match_odds (id, match_id, specifier, odds) values (6, 2, 'DRAW', 6.5)