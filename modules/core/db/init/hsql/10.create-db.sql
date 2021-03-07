-- begin TECHNICALSUPPORT_APPEAL
create table TECHNICALSUPPORT_APPEAL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_CREATE date,
    PRODUCT varchar(255) not null,
    DESCRIPTION longvarchar not null,
    ANSWER longvarchar,
    --
    primary key (ID)
)^
-- end TECHNICALSUPPORT_APPEAL
