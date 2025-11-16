CREATE OR REPLACE PROCEDURE SP_ARTICLE_CREATE (
    p_title IN VARCHAR2,
    p_content IN VARCHAR2,
    p_author IN VARCHAR2,
    p_new_id OUT NUMBER,
    p_created_at OUT TIMESTAMP,
    p_updated_at OUT TIMESTAMP
) IS
BEGIN
    INSERT INTO article (id, title, content, author)
    VALUES (article_seq.NEXTVAL, p_title, p_content, p_author)
    RETURNING id, created_at, updated_at INTO p_new_id, p_created_at, p_updated_at;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE SP_ARTICLE_GET_ALL (
    p_cursor OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN p_cursor FOR
        SELECT id, title, content, author, created_at, updated_at
        FROM article
        ORDER BY id DESC;
END;
/

CREATE OR REPLACE PROCEDURE SP_ARTICLE_GET_BY_ID (
    p_id IN NUMBER,
    p_cursor OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN p_cursor FOR
        SELECT id, title, content, author, created_at, updated_at
        FROM article
        WHERE id = p_id;
END;
/

CREATE OR REPLACE PROCEDURE SP_ARTICLE_UPDATE (
    p_id IN NUMBER,
    p_title IN VARCHAR2,
    p_content IN VARCHAR2,
    p_created_at OUT TIMESTAMP,
    p_updated_at OUT TIMESTAMP
) IS
BEGIN
    UPDATE article
    SET title = p_title,
        content = p_content,
        updated_at = SYSTIMESTAMP
    WHERE id = p_id
    RETURNING created_at, updated_at INTO p_created_at, p_updated_at;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE SP_ARTICLE_DELETE (
    p_id IN NUMBER
) IS
BEGIN
    DELETE FROM article
    WHERE id = p_id;
    COMMIT;
END;
/