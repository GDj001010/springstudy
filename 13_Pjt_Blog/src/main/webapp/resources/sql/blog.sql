DROP TABLE GOOD_T;
DROP TABLE COMMENT_T;
DROP TABLE SUMMERNOTE_IMAGE_T;
DROP TABLE BLOG_T;
DROP TABLE MEMBER_T;


-- 사용자
CREATE TABLE MEMBER_T (
    MEMBER_NO NUMBER NOT NULL,
    ID        VARCHAR2(30 BYTE) NOT NULL UNIQUE,
    PW        VARCHAR2(30 BYTE) NOT NULL,
    NAME      VARCHAR2(30 BYTE)
);

-- 블로그
CREATE TABLE BLOG_T (
    BLOG_NO     NUMBER  NOT NULL,
    TITLE       VARCHAR2(100 BYTE) NOT NULL,
    CONTENT     CLOB,
    HIT         NUMBER NOT NULL,
    CREATED_AT  DATE,
    MODIFIED_AT DATE,
    MEMBER_NO   NUMBER
);

-- 블로그 본문에 작성 에디터 SUMMERNOTE에서 사용한 이미지의 목록
CREATE TABLE SUMMERNOTE_IMAGE_T (
    PATH            VARCHAR2(300 BYTE),
    FILESYSTEM_NAME VARCHAR2(50 BYTE),
    BLOG_NO         NUMBER
);

-- 댓글 (1단 계층형, 대댓글 불가한 형태)
CREATE TABLE COMMENT_T (
    COMMENT_NO  NUMBER  NOT NULL,
    CONTENT     VARCHAR2(4000 BYTE) NOT NULL,
    STATE       NUMBER,     -- 정상 1, 삭제 -1
    DEPTH       NUMBER,     -- 댓글 0, 대댓글, 1
    GROUP_NO    NUMBER,     -- 댓글과 댓글에 달린 댓글은 같은 그룹
    CREATED_AT  DATE,
    BLOG_NO     NUMBER,
    MEMBER_NO   NUMBER
);

-- 좋아요
CREATE TABLE GOOD_T (
    MEMBER_NO   NUMBER,
    BLOG_NO     NUMBER,
    MARKED_AT   DATE
);
    
    
-- 사용자 기본키
ALTER TABLE MEMBER_T
    ADD CONSTRAINT PK_MEMBER
        PRIMARY KEY(MEMBER_NO);
        
-- 블로그 기본키
ALTER TABLE BLOG_T
    ADD CONSTRAINT PK_BLOG
        PRIMARY KEY(BLOG_NO);

-- 댓글 기본키
ALTER TABLE COMMENT_T
    ADD CONSTRAINT PK_COMMENT
        PRIMARY KEY(COMMENT_NO);
    
    
    
    
    
    
    
    
    
    
    