select attr_value , attr_name ,sm.attr_id, ss.subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and sm.attr_name like '%NCBI%' and ss.subpid=7 and sm.attr_id=808;



update  SEQUENCEMETA.seqattrvalue ss set ss.attr_value='ADUK00000000'
where ss.attr_id=808 and subpid=7


select attr_value , attr_name ,sm.attr_id, ss.subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and sm.attr_name like '%NCBI%';


select ss.subpid, attr_name , attr_value
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm , sequencemeta.seqsubproject sp
where ss.attr_id= sm.attr_id  and sp.subpid= ss.subpid and sp.pid=11 


select count(*) from SEQUENCEMETA.SEQATTRVALUE where subpid in
( select subpid from SEQUENCEMETA.seqsubproject where pid=9);

select count(subpid) from SEQUENCEMETA.seqsubproject where pid=9;


select ss.subpid, attr_name , attr_value
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm , sequencemeta.seqsubproject sp
where ss.attr_id= sm.attr_id  and sp.subpid= ss.subpid and sp.pid=12 and ss.subpid>1300
order by 1


update SEQUENCEMETA.seqattrvalue  t1 
set attr_value=(select replace(attr_value,'"') from SEQUENCEMETA.seqattrvalue t2 
where t1.attr_id=t2.attr_id and t1.subpid=t2.subpid and t1.subpid>1);


update SEQUENCEMETA.TEMPATTVALUE  t1 
set attr_value=(select replace(attr_value,'"') from SEQUENCEMETA.TEMPATTVALUE t2 
where t1.attr_id=t2.attr_id and t1.subpid=t2.subpid and t1.subpid>0);

select  distinct attr_name , sm.attr_id, attr_value, ss.subpid 
from SEQUENCEMETA.TEMPATTVALUE ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and sm.attr_name like '%Geographical%' and ss.subpid>1011 order by 3


select * from SEQUENCEMETA.seqsubproject where pid=12 order by 3; 


select  distinct attr_name , sm.attr_id, attr_value, ss.subpid 
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and sm.attr_name like '%Geographical%' and ss.subpid>1011 order by 3



select * from SEQUENCEMETA.seqsubproject where pid=4

select  distinct sp.NAME, sp.DESCRIPTION, sa.Attr_value AS PROJECT_ID
from SEQUENCEMETA.seqproject sp , SEQUENCEMETA.seqsubproject ss, SEQUENCEMETA.seqattrvalue sa 
where sp.pid= ss.pid and ss.subpid= sa.subpid and sa.attr_id=930


update SEQUENCEMETA.seqattrvalue  t1 
set attr_value=(select replace(attr_value,'"') from SEQUENCEMETA.seqattrvalue t2 
where t1.attr_id=t2.attr_id and t1.subpid=t2.subpid)
where t1.subpid>1;


update sequencemeta.metadataattr s1 set s1.patric_attr=(
select initcap(LOWER(s2.attr_name)) from sequencemeta.metadataattr s2
where  s1.attr_id= s2.attr_id and s2.domain= s1.domain and s1.domain='CORE' 
and s2.patric_attr is null)
where s1.patric_attr is null



select  distinct attr_name , sm.attr_id, attr_value, ss.subpid 
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm, sequencemeta.seqsubproject sp
where ss.attr_id= sm.attr_id and ss.subpid= sp.subpid and sp.pid=9 order by 4



select su.category, su.attr_name from SEQUENCEMETA.JCVI_LEPT_NEW_CORE su
where su.attr_name not in (select sm.attr_name from SEQUENCEMETA.metadataattr sm
where  su.category= sm.category );

insert into SEQUENCEMETA.metadataattr (DOMAIN,CATEGORY,ATTR_NAME)
(select 'CORE', su.category, attr_name from
SEQUENCEMETA.JCVI_LEPT_NEW_CORE su
where attr_name is not null and
su.attr_name not in (select distinct sm.attr_name from SEQUENCEMETA.metadataattr  sm
where  su.category= sm.category ))



