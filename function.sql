create or replace function sequencemeta.study_specific_attributes(p_subpid IN integer) return varchar2 as 

  attr_list varchar2(4000);
  cursor av_pairs is
	 select
	  sp.pid, sp.name project_name, ssp.name seq_name,  mda.attr_name, sav.attr_value
	 from
	  sequencemeta.seqproject sp,
	  sequencemeta.seqsubproject ssp,
	  sequencemeta.metadataattr mda,
	  sequencemeta.seqattrvalue sav
	 where
	  mda.category NOT IN
	   ('Project Information','Submission Information','Collection Information',
		'Isolate Organism','Host Organism','Environmental Samples','Geographic Location',
		'Sequencing Information')
	 and
	   sav.attr_value is not NULL
	 and
	   sp.pid=ssp.pid
	 and
	   ssp.subpid = sav.subpid
	 and
	   sav.attr_id = mda.attr_id
	 and
	  ssp.subpid = p_subpid
	 order by
	   pid, seq_name, attr_name;
begin 
   attr_list := '';
   for attr in av_pairs loop
     attr_list := attr_list || attr.attr_name || ': ' || attr.attr_value || ' ### ';
   end loop;
   return (attr_list);
end study_specific_attributes;

