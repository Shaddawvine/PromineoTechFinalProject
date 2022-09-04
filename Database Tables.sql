Drop table if exists campaign;
Drop table if exists game_master;
Drop table if exists player_pc;
Drop table if exists player;

create table player(
player_id int not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
phone_number varchar(20),
primary key (player_id)
);

create table player_pc(
pc_id int not null auto_increment,
player_id int not null,
first_name varchar(100) not null,
last_name varchar(100) not null,
lvl int(3) not null,
class varchar(60) not null,
race varchar(30) not null,
primary key (pc_id),
foreign key (player_id) references player(player_id) on delete cascade
);

create table game_master(
gm_id int not null auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
phone_number varchar(20),
primary key (gm_id)
);

create table campaign(
campaign_id int not null auto_increment,
gm_fk int not null,
player_fk int not null,
primary key (campaign_id),
foreign key (gm_fk) references game_master(gm_id) on delete cascade,
foreign key (player_fk) references player(player_id) on delete cascade
);
