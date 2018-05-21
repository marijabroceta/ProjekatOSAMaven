INSERT INTO users(name,username,password,photo_user)VALUES('Marija','mara','mara123',NULL);
INSERT INTO users(name,username,password,photo_user)VALUES('Milana','mika','mika123',NULL);
INSERT INTO users(name,username,password,photo_user)VALUES('Bole','bole','bole123',NULL);
INSERT INTO users(name,username,password,photo_user)VALUES('Pera','pera','pera123',NULL);
INSERT INTO users(name,username,password,photo_user)VALUES('Janko','janko','janko123',NULL);

INSERT INTO post(title,description,author_id,photo,post_date,likes,dislikes,longitude,latitude)VALUES('Avengers Infinity War release on April 26th','Theres a reason that all of Marvels heroes have to come together in Infinity War, and his name is Thanos',1,LOAD_FILE('E://ProjekatOSA//OSANews//static//avengers1.png'),'2018-03-26 19:03:21',25,6,0,0);
INSERT INTO post(title,description,author_id,photo,post_date,likes,dislikes,longitude,latitude)VALUES('Deadpool 2 release on May 18th','Deadpool 2, the Ryan Reynolds-led sequel, is on pace to open to a huge $150 million in North America this summer',2,NULL,'2018-04-15 09:45:33',30,4,0,0);
INSERT INTO post(title,description,author_id,photo,post_date,likes,dislikes,longitude,latitude)VALUES('Amazing victory of Liverpool','Liverpool ran riot against AS Roma in the first leg of the Champions League semi-final to clinch a 5-2 win at Anfield',3,NULL,'2018-04-26 16:36:24',23,5,0,0);

INSERT INTO comment(comm_title,comm_description,comm_date,comm_likes,comm_dislikes,post_id,author_id)VALUES('Movie lover','Its going to be awesome movie','2018-03-26 13:34:52',12,4,1,4);
INSERT INTO comment(comm_title,comm_description,comm_date,comm_likes,comm_dislikes,post_id,author_id)VALUES('Super awesome','I cant wait to watch it','2018-04-24 18:42:12',15,5,1,5);
INSERT INTO comment(comm_title,comm_description,comm_date,comm_likes,comm_dislikes,post_id,author_id)VALUES('Deadpool','This movie is going to be fantastic','2018-04-17 15:48:15',18,7,2,1);
INSERT INTO comment(comm_title,comm_description,comm_date,comm_likes,comm_dislikes,post_id,author_id)VALUES('Liverpool fan','That was great game','2018-04-07 10:26:14',23,7,3,2);

INSERT INTO tag(tag_name)VALUES('#movie');
INSERT INTO tag(tag_name)VALUES('#marvel');
INSERT INTO tag(tag_name)VALUES('#footbal');

INSERT INTO post_tag(post_id,tag_id)VALUES(1,1);
INSERT INTO post_tag(post_id,tag_id)VALUES(1,2);
INSERT INTO post_tag(post_id,tag_id)VALUES(2,1);
INSERT INTO post_tag(post_id,tag_id)VALUES(2,2);
INSERT INTO post_tag(post_id,tag_id)VALUES(3,3);

