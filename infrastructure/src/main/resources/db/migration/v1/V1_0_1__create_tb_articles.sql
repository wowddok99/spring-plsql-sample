CREATE SEQUENCE article_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE article (
    id          NUMBER          DEFAULT article_seq.NEXTVAL NOT NULL,
    title       VARCHAR2(200)   NOT NULL,
    content     VARCHAR2(4000)  NULL,
    author      VARCHAR2(100)   NULL,

    created_at  TIMESTAMP       DEFAULT SYSTIMESTAMP NOT NULL,
    updated_at  TIMESTAMP       DEFAULT SYSTIMESTAMP NOT NULL,

    CONSTRAINT pk_article PRIMARY KEY (id)
);

COMMENT ON TABLE article IS '아티클(게시글) 테이블';

COMMENT ON COLUMN article.id             IS '아티클 PK (Sequence)';
COMMENT ON COLUMN article.title          IS '아티클 제목';
COMMENT ON COLUMN article.content        IS '아티클 내용';
COMMENT ON COLUMN article.author         IS '작성자명';
COMMENT ON COLUMN article.created_at     IS '생성일자';
COMMENT ON COLUMN article.updated_at     IS '수정일자';