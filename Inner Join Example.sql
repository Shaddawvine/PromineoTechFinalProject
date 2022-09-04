Select game_master.*, player.* from game_master
Inner Join player On player_id between 0 and 7
and gm_id = 1