create table SEQUENCEMETA.seqproject(
pid number,
name varchar2(4000),
description varchar2(4000)
);

create table SEQUENCEMETA.seqsubproject(
spid vrchar2(400),
pid number,
name varchar2(4000),
description varchar2(4000)
);

create table SEQUENCEMETA.seqattrvalue(
spid varchar2(400),
attr_id number,
attr_value varchar2(400)
);


insert into SEQUENCEMETA.SEQATTRVALUE (SubPID,ATTR_ID,ATTR_VALUE)
(select '1', attr_id, ID62777 from  SEQUENCEMETA.BURKHOLDERIACORE sb,
 SEQUENCEMETA.METADATAATTR sm
 where sb.CATAGORY=sm.CATAGORY AND sb.ATTR_NAME=sm.ATTR_NAME
)
insert into SEQUENCEMETA.SEQATTRVALUE (SubPID,ATTR_ID,ATTR_VALUE)
(select '2', attr_id, ID62777 from  SEQUENCEMETA.BURKHOLDERIACORE sb,
 SEQUENCEMETA.METADATAATTR sm
 where sb.CATAGORY=sm.CATAGORY AND sb.ATTR_NAME=sm.ATTR_NAME
)
insert into SEQUENCEMETA.SEQATTRVALUE (SubPID,ATTR_ID,ATTR_VALUE)
(select '3', attr_id, ID62777 from  SEQUENCEMETA.BURKHOLDERIACORE sb,
 SEQUENCEMETA.METADATAATTR sm
 where sb.CATAGORY=sm.CATAGORY AND sb.ATTR_NAME=sm.ATTR_NAME
)
insert into SEQUENCEMETA.SEQATTRVALUE (SubPID,ATTR_ID,ATTR_VALUE)
(select '4', attr_id, ID62777 from  SEQUENCEMETA.BURKHOLDERIACORE sb,
 SEQUENCEMETA.METADATAATTR sm
 where sb.CATAGORY=sm.CATAGORY AND sb.ATTR_NAME=sm.ATTR_NAME
)

insert into SEQUENCEMETA.SEQATTRVALUE (SubPID,ATTR_ID,ATTR_VALUE)
(select '5', attr_id, ID62787 from  SEQUENCEMETA.BURKHOLDERIACORE sb,
 SEQUENCEMETA.METADATAATTR sm
 where sb.CATAGORY=sm.CATAGORY AND sb.ATTR_NAME=sm.ATTR_NAME
)



CHECK ORACLE DATABASE SIZE

select (select sum(bytes)/1024/1024 from dba_data_files)+
(select sum(bytes)/1024/1024 from dba_temp_files) "Size in MB" from dual;

select sum(bytes / (1024*1024)) "DB Size in MB" from dba_data_files;


truncate table SEQUENCEMETA.TEMPATTVALUE