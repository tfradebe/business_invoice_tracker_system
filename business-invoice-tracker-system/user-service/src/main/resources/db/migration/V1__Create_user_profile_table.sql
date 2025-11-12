CREATE TABLE USER_PROFILES
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name     VARCHAR(255) NOT NULL,
    user_password VARCHAR      NOT NULL,
    email         VARCHAR      NOT NULL UNIQUE,

    created_at    TIMESTAMP    NOT NULL,
    updated_at    TIMESTAMP    NOT NULL
);

CREATE INDEX idx_users_username ON USER_PROFILES (user_name);
CREATE INDEX idx_users_email ON USER_PROFILES (email);