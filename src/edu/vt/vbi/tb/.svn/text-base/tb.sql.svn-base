
create table SEQUENCEMETA.TB_CORE(
Category varchar2(400),
ATTR_NAME varchar2(400),
GENOME1	 varchar2(4000),
GENOME2	 varchar2(4000),
GENOME3	 varchar2(4000),
GENOME4	 varchar2(4000),
GENOME5	 varchar2(4000),
GENOME6	 varchar2(4000),
GENOME7	 varchar2(4000),
GENOME8	 varchar2(4000),
GENOME9	 varchar2(4000),
GENOME10	 varchar2(4000),
GENOME11	 varchar2(4000),
GENOME12	 varchar2(4000),
GENOME13	 varchar2(4000),
GENOME14	 varchar2(4000),
GENOME15	 varchar2(4000),
GENOME16	 varchar2(4000),
GENOME17	 varchar2(4000),
GENOME18	 varchar2(4000),
GENOME19	 varchar2(4000),
GENOME20	 varchar2(4000),
GENOME21	 varchar2(4000),
GENOME22	 varchar2(4000),
GENOME23	 varchar2(4000),
GENOME24	 varchar2(4000),
GENOME25	 varchar2(4000),
GENOME26	 varchar2(4000),
GENOME27	 varchar2(4000),
GENOME28	 varchar2(4000),
GENOME29	 varchar2(4000),
GENOME30	 varchar2(4000),
GENOME31	 varchar2(4000),
GENOME32	 varchar2(4000),
GENOME33	 varchar2(4000),
GENOME34	 varchar2(4000),
GENOME35	 varchar2(4000),
GENOME36	 varchar2(4000),
GENOME37	 varchar2(4000),
GENOME38	 varchar2(4000),
GENOME39	 varchar2(4000),
GENOME40	 varchar2(4000),
GENOME41	 varchar2(4000),
GENOME42	 varchar2(4000)
)



insert into SEQUENCEMETA.metadataattr (DOMAIN,CATEGORY,ATTR_NAME)
(select 'CORE', 'Other', attr_name from SEQUENCEMETA.tb_core su
where attr_name is not null and
attr_name not in (select distinct attr_name from SEQUENCEMETA.metadataattr  sm
where su.category= sm.category ))

