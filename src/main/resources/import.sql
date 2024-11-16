INSERT INTO match (id, description, match_date, match_time, team_a, team_b, sport) values (nextval('match_seq'), 'OSFP-PAO', '2024-10-31', '18:30', 'OSFP', 'PAO', 0)
INSERT INTO match (id, description, match_date, match_time, team_a, team_b, sport) values (nextval('match_seq'), 'AEK-PAOK', '2024-11-1', '19:30', 'AEK', 'PAOK', 1)

INSERT INTO match_odds (id, match_id, specifier, odds) values (nextval('match_odds_seq'), 1, 'PAO WIN', 2.5)
INSERT INTO match_odds (id, match_id, specifier, odds) values (nextval('match_odds_seq'), 1, 'AEK WIN', 3)
INSERT INTO match_odds (id, match_id, specifier, odds) values (nextval('match_odds_seq'), 1, 'DRAW', 4.5)
INSERT INTO match_odds (id, match_id, specifier, odds) values (nextval('match_odds_seq'), 2, 'AEK WIN', 3.5)
INSERT INTO match_odds (id, match_id, specifier, odds) values (nextval('match_odds_seq'), 2, 'PAOK WIN', 3.8)
INSERT INTO match_odds (id, match_id, specifier, odds) values (nextval('match_odds_seq'), 2, 'DRAW', 6.5)