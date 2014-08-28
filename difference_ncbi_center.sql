select count(*) from SEQUENCEMETA.ncbimetadata;

select count(*) from SEQUENCEMETA.seqsubproject;


select distinct subpid from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and ss.attr_value is not null and (sm.attr_name like '%NCBI_Tax%' OR sm.attr_name like 'NCBI_Pr%');

select count(distinct subpid) from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and ss.attr_value is not null and (sm.attr_name like '%NCBI_tax%' OR sm.attr_name like 'NCBI_Pr%');


select distinct subpid from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id) OR (ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id)

select count(distinct subpid) from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id) OR (ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id)


select distinct subpid from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and ss.attr_value is not null and (sm.attr_name like '%NCBI_tax%' OR sm.attr_name like 'NCBI_Pr%')
and subpid not in (
select distinct subpid from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id) OR (ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id)
)


select distinct subpid from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and ss.attr_value is not null and (sm.attr_name like '%NCBI_tax%' OR sm.attr_name like 'NCBI_Pr%')
minus
select distinct subpid from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id) OR (ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id)



select p.name, p.DESCRIPTION, sub.name AS "SUB_Project_ID" from sequencemeta.seqproject p, sequencemeta.seqsubproject sub
where sub.pid= p.pid and sub.subpid not in (
select distinct subpid from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id) OR (ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id)
)
order by 1,2,3


select attr_value , attr_name ,sm.attr_id, ss.subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and (sm.attr_name like '%NCBI_T%' OR sm.attr_name like 'NCBI_P%');

select distinct attr_value , attr_name ,ss.subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and (sm.attr_name like '%NCBI_T%' OR sm.attr_name like 'NCBI_P%') and (ss.subpid=2 or  ss.subpid=257)
order by 2

select distinct attr_value , attr_name ,ss.subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and (sm.attr_name like '%NCBI_T%' OR sm.attr_name like 'NCBI_P%') and  ss.attr_value like '%454%'
order by 2

select distinct attr_value , attr_name ,ss.subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.metadataattr sm
where ss.attr_id= sm.attr_id and  ss.attr_value like '%454%'
order by 2

select distinct subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where (ss.attr_id= 808 and ss.attr_value= ncbi.GENBANK_ACCESSIONS) 
OR (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id)
OR (ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id)


select p.name, p.DESCRIPTION, sub.name AS "SUB_Project_ID" from sequencemeta.seqproject p, sequencemeta.seqsubproject sub
where sub.pid= p.pid and sub.subpid not in
(select  subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where (ss.attr_id= 808 and ss.attr_value= ncbi.GENBANK_ACCESSIONS) 
OR (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id)
OR (ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id))



select p.name, p.DESCRIPTION, sub.name AS "SUB_Project_ID" 
from sequencemeta.seqproject p, sequencemeta.seqsubproject sub, 
where sub.pid= p.pid and


select  subpid
from SEQUENCEMETA.seqattrvalue ss 
where ss.attr_id=930 and ss.attr_value=51461 


select p.name, p.DESCRIPTION, sub.name AS "SUB_Project_ID" , ss.attr_id, ss.attr_value, sm.attr_name
from sequencemeta.seqproject p, sequencemeta.seqsubproject sub, SEQUENCEMETA.seqattrvalue ss , sequencemeta.metadataattr sm
where sub.pid= p.pid and ss.subpid= sub.subpid and sub.subpid=657 and ss.attr_id= sm.attr_id



select p.name, p.DESCRIPTION, sub.name AS "SUB_Project_ID" , ss.attr_id, ss.attr_value, sm.attr_name
from sequencemeta.seqproject p, sequencemeta.seqsubproject sub, SEQUENCEMETA.seqattrvalue ss , sequencemeta.metadataattr sm
where sub.pid= p.pid and ss.subpid= sub.subpid and sub.subpid in (1,2,3,4,5) and ss.attr_id= sm.attr_id
order by 2, 3,4



select distinct subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where (ss.attr_id= 808 and ss.attr_value= ncbi.GENBANK_ACCESSIONS) 
OR (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id)
OR (ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id)
order by 1



select  sub.name AS "SUB_Project_ID", sub.subpid from sequencemeta.seqsubproject sub
where sub.subpid in
(select subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where ss.attr_id= 808 and ss.attr_value= ncbi.GENBANK_ACCESSIONS)
UNION
select  sub.name AS "SUB_Project_ID", sub.subpid from sequencemeta.seqsubproject sub
where sub.subpid in
(select subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id)
UNION
select  sub.name AS "SUB_Project_ID", sub.subpid from sequencemeta.seqsubproject sub
where sub.subpid in
(select subpid
from SEQUENCEMETA.seqattrvalue ss, SEQUENCEMETA.ncbimetadata ncbi
where ss.attr_id=43 and ss.attr_value= ncbi.ncbi_taxon_id )
order by 2,1

 (ss.attr_id= 930 and ss.attr_value= ncbi.ncbi_project_id)


