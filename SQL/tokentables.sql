use mydb;

CREATE TABLE oauth_access_token (
    token_id varchar(255) NOT NULL,
    token blob,
    authentication_id varchar(255) DEFAULT NULL, 
    user_name varchar(255) DEFAULT NULL, 
    client_id varchar(255) DEFAULT NULL, 
    authentication blob,
    refresh_token varchar(255) DEFAULT NULL, 
    PRIMARY KEY (token_id)
);


CREATE TABLE oauth_refresh_token ( 
    token_id varchar(255) NOT NULL,
    token blob,
    authentication blob,
    PRIMARY KEY (token_id)
);


SELECT * FROM oauth_access_token;
SELECT * FROM oauth_refresh_token;