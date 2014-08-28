package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.standard.Chromaticity;

public class GOLDData {
	
	Connection conn;
	String sql="SELECT GENUS, ORGANISM_NAME, SPECIES, DOMAIN, STRAIN, SEROVAR_BIOVAR, COMMON_NAME,NCBI_TAXON_ID," +
			" GENOME_DATA, LOCUS_TAG, OXYGEN_REQUIREMENT, CULTURE_COLLECTION, SPORULATION," +
			"PRESSURE,TEMPERATURE_RANGE,SALINITY,PH,GRAM_STAINING,PHENOTYPE,ENERGY_SOURCE," +
			"NCBI_PRO_NAME, PROJECT_TYPE, PROJECT_STATUS, COMPLETION_DATE, " +
			"SEQUENCING_CENTERS, AVAILABILITY,CONTACT_NAME,CONTACT_EMAIL,CONTACT_URL,PUBLICATION," +
			"SHORT_READS_ARCHIVE_ID, SEQUENCING_STATUS, SEQUENCING_QUALITY, COMMENTS,LIBRARY_METHOD," +
			"READS_COUNT,VECTOR,ASSEMBLY_METHOD,SEQUENCING_DEPTH,GENE_CALLING_METHOD,CONTIG_COUNT,SIZE_KB," +
			"ORFS,CHROMOSOME_COUNT, PLASMID_COUNT, GC_CONTENT, SEQUENCING_METHOD, SEQUENCING_COUNTRY," +
			"ISOLATION_SITE, ISOLATION_SOURCE, ISOLATION_COMMENTS, COLLECTION_DATE, ISOLATION_COUNTRY," +
			"ISOLATION_PUBMED_ID, GEOGRAPHIC_LOCATION,LATITUDE,LONGITUDE,ALTITUDE,DEPTH," +
			"HOST_NAME,HOST_TAXON_ID,HOST_GENDER,HOST_AGE,HOST_RACE,HOST_HEALTH,HOST_MEDICATION," +
			"HOST_SPECIFICITY,BODY_SAMPLE_SITE,BODY_PRODUCT,BODY_SAMPLE_SUBSITE,HOST_COMMENTS," +
			"CELL_SHAPE,CELL_DIAMETER,CELL_LENGTH,COLOR," +
			"BIOTIC_RELATIONSHIPS,SYMBIOTIC_INTERACTION,SYMBIOTIC_RELATIONSHIP,SYMBIONT_NAME," +
			"SYMBIONT_TAXON_ID,CELL_ARRANGEMENT,DISEASE,HABITAT,TEMPERATURE,METABOLISM,MOTILITY " +
			"FROM "+SchemaName.SCHEMA+"metadata";
	
	public GOLDData() {
		try {
			conn=DatabaseManager.instance().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void updateTables() {
		try{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		String genus="";
		String orgName="";
		String species="";
		String domain="";
		String strain="";
		String biovar="";
		String commonName="";
		String taxonid="";		
		String genomeDate="";
		String locusTag="";
		String oxygenReuirement="";
		String cultureCollection="";
		String sporulation="";
		String pressure="";
		String temperatureRange="";
		String salinity="";
		String ph="";
		String gramStaining="";
		String phenotype;
		String energySource;
		
		String projectName="";
		String projectType="";
		String projectStatus="";
		String completionDate="";
		String sequenceCenter="";
		String availability="";
		String contactName="";
		String email="";
		String contactUrl="";
		String publication="";
		String sequenceStatus="";
		String sequenceQuality="";
		String comments="";
		String libraryMethod="";
		String readsCount="";
		String vector;
		String assemblyMethod;
		String sequenceDepth;
		String geneCallMethod="";
		String contigCounts="";
		String sizeKB="";
		String orfs="";
		String chloromoseCount="";
		String plasmidCounts="";
		String gcContent="";
		String sequenceMethod="";
		String sequenceCountry="";
		String isolationSite;
		String isolationSource;
		String isolationComments;
		String collectionDate;
		String isolationCountry="";
		String geographLocation;
		String latitute="";
		String longitude="";
		String altitude="";
		String depeth;
		
		String hostName="";
		String hosttaxonID="";
		String hostGender="";
		String hostAge;
		String hostRace;
		String hostHealth;
		String hostmedication="";
		String hostSpecificity="";
		String bodySampleSite="";
		String bodyProduct="";
		String bodysampleSubSite="";
		String hostComments="";
		String cellShape="";
		String cellDiameter="";
		String cellLength="";
		String color="";
		
		String bioticRelationship="";
		String symbioticInteraction;
		String symbolicelationship;
		String symbiontName="";
		String symbiontTaxonID="";
		String cellarrangement="";
		String disease="";
		String habitat="";
		String temperature;
		String metabolism;
		String motility;
	
		String temp="";
		
		conn.setAutoCommit(false);
		
		while(rs.next()){
			Organism organism=new Organism(conn);
			System.out.println("id :\t"+organism.getORGANISM_ID());
			genus=rs.getString("GENUS");
			organism.setGENUS(genus);
			
			orgName=rs.getString("ORGANISM_NAME");
			organism.setDISPLAY_NAME(orgName);
			
			System.out.println("species :\t"+orgName);
			species=rs.getString("SPECIES");
			String sp=updateString(species);
			organism.setSpecies(sp);
			
			domain=rs.getString("DOMAIN");
			String d=updateString(domain);
			organism.setDOMAIN(d);
			
			strain=rs.getString("STRAIN");
			String st=updateString(strain); 
			organism.setStrain(st);
			System.out.println("Strain :\t"+st);
			
			biovar=rs.getString("SEROVAR_BIOVAR");
			organism.setSEROVAR_BIOVAR(biovar);
			
			commonName=rs.getString("COMMON_NAME");
			organism.setDISPLAY_NAME(commonName);
			
			taxonid=rs.getString("NCBI_TAXON_ID");
			organism.setTaxonID(taxonid);
			
			genomeDate=rs.getString("GENOME_DATA");
			organism.setGENOME_DATA(genomeDate);
			
			locusTag=rs.getString("LOCUS_TAG");
			oxygenReuirement=rs.getString("OXYGEN_REQUIREMENT");
			organism.setOXYGEN_REQUIREMENT(oxygenReuirement);
			
			cultureCollection=rs.getString("CULTURE_COLLECTION");
			organism.setCULTURE_COLLECTION(cultureCollection);
			
			sporulation=rs.getString("SPORULATION");
			organism.setSporulation(sporulation);
			System.out.println("Sporulation :\t"+sporulation);
			
			pressure=rs.getString("PRESSURE");
		
			temperatureRange=rs.getString("TEMPERATURE_RANGE");
			organism.setTEMPERATURE_RANGE(temperatureRange);
			
			salinity=rs.getString("SALINITY");
			organism.setSalinity(salinity);
						
			ph=rs.getString("PH");
			organism.setpH(ph);
			System.out.println("ph:\t"+ph);
			
			gramStaining=rs.getString("GRAM_STAINING");
			organism.setGRAM_STAINING(gramStaining);
			System.out.println(" GRAM_STAINING \t"+gramStaining);
			
			phenotype=rs.getString("PHENOTYPE");
			organism.setPHENOTYPES(phenotype);
			System.out.println("PHENOTYPE \t"+phenotype);
			
			energySource=rs.getString("ENERGY_SOURCE");
			organism.setENERGY_SOURCES(energySource);
			System.out.println("ENERGY_SOURCE \t"+energySource);
			
			bioticRelationship=rs.getString("BIOTIC_RELATIONSHIPS");
			organism.setBIOTIC_RELATIONSHIPS(bioticRelationship);
			System.out.println("BIOTIC_RELATIONSHIPS\t"+bioticRelationship);
			
			symbioticInteraction=rs.getString("SYMBIOTIC_INTERACTION");
			organism.setSYMBIO_PHYSICAL_INTER(symbioticInteraction);
			
			System.out.println("\t"+symbioticInteraction);
			
			symbolicelationship=rs.getString("SYMBIOTIC_RELATIONSHIP");
			organism.setSYMBIOTIC_RELATIONSHIP(symbolicelationship);
			System.out.println("symb relation :\t"+symbolicelationship);
			
			symbiontName=rs.getString("SYMBIONT_NAME");
			organism.setSYMBIONT_NAME(symbiontName);
			
			symbiontTaxonID=rs.getString("SYMBIONT_TAXON_ID");
			organism.setSYMBIONT_TAXON_ID(symbiontTaxonID);
			
			cellarrangement=rs.getString("CELL_ARRANGEMENT");
			
			disease=rs.getString("DISEASE");
			String t=updateString(disease);

			System.out.println("disease :\t"+t);
			organism.setDISEASE(t);
			
			habitat= rs.getString("HABITAT");
			
			temperature=rs.getString("TEMPERATURE");
			organism.setTEMPERATURE_OPTIMAL(temperature);
			
			metabolism=rs.getString("METABOLISM");
			organism.setMETABOLISM(metabolism);
			
			motility= rs.getString("MOTILITY");
			organism.setMotility(motility);
			
			System.out.println("update organism table ");
			
			/** update organism table**/
			organism.updateOrganism(conn);			
			
			Project project=new Project(conn);
			
			projectName=rs.getString("NCBI_PRO_NAME");
			String pn=updateString(projectName);
			project.setNAME(pn);
			
			projectType=rs.getString("PROJECT_TYPE");			
			String pt=updateString(projectType);
			project.setTYPE(pt);
			
			projectStatus=rs.getString("PROJECT_STATUS");
			project.setPROJECT_STATUS(projectStatus);
			
			completionDate=rs.getString("COMPLETION_DATE");
			project.setCOMPLETION_DATE(completionDate);
			
			sequenceCenter=rs.getString("SEQUENCING_CENTERS");
			project.setSEQUENCING_CENTER(sequenceCenter);
			
			availability=rs.getString("AVAILABILITY");
			project.setSEQENCE_AVAILABILITY(availability);
			
			System.out.println("update project table ");
			//insert into project table
			project.updateProject(conn);
			
			//update 
			ProjectOrganism po=new ProjectOrganism(project.getPROJECT_ID(), organism.getORGANISM_ID());
			po.setISOLATE_PHENOTYPE(phenotype);
			po.updateProjectOrganism(conn);
			
			
			Cell cell=new Cell(conn, organism.getORGANISM_ID());
			
			cellShape=rs.getString("CELL_SHAPE");
			cell.setCELL_SHAPE(cellShape);
			
			cellDiameter=rs.getString("CELL_DIAMETER");
			cell.setCELL_DIAMETER(cellDiameter);
			
			cellLength=rs.getString("CELL_LENGTH");
			cell.setCELL_LENGTH(cellLength);
			
			color=rs.getString("COLOR");
			cell.setCOLOR(color);
			
			System.out.println("update Cell table ");
			//insert into cell table
			cell.updateCell(conn);

			Person p=new Person(conn);			
			contactName=rs.getString("CONTACT_NAME");
			p.setFULL_NAME(contactName);
			
			email=rs.getString("CONTACT_EMAIL");
			p.setEMAIL(email);			
			contactUrl=rs.getString("CONTACT_URL");
			//update person table
			p.updatePerson(conn);
			
			
			ProjectContactPerson pcp=new ProjectContactPerson(project.getPROJECT_ID(), p.getPERSON_ID());
			pcp.updateProjectContactPerson(conn);
			
			publication=rs.getString("PUBLICATION");
			rs.getString("SHORT_READS_ARCHIVE_ID");
			
			SequenceSource ss=new SequenceSource(conn, project.getPROJECT_ID());
			ss.updateSequenceSource(conn);
			
			Sequencing s=new Sequencing(conn, ss.getSEQUENCE_SOURCE_ID());
			
			sequenceStatus=rs.getString("SEQUENCING_STATUS");
			s.setSequenceStatus(sequenceStatus);
			
			sequenceQuality=rs.getString("SEQUENCING_QUALITY");
			s.setSEQUENCE_QUALITY_CHECK(sequenceQuality);
			
			comments=rs.getString("COMMENTS");
			
			libraryMethod=rs.getString("LIBRARY_METHOD");
			s.setLIBRARY_METHOD(libraryMethod);
			
			readsCount=rs.getString("READS_COUNT");
			int rc=0;
			try{
				rc=Integer.valueOf(readsCount);
			}
			catch(Exception e){
				rc=0;
			}
			s.setREADS_COUNT(rc);
			
			vector=rs.getString("VECTOR");
			s.setVECTOR(vector);
			
			assemblyMethod=rs.getString("ASSEMBLY_METHOD");
			s.setASSEMBLY_NAME(assemblyMethod);
			
			sequenceDepth=rs.getString("SEQUENCING_DEPTH");
			int sd=0;
			try{
				sd=Integer.valueOf(sequenceDepth);
			}
			catch(Exception e){
				sd=0;
			}
			
			s.setSEQUENCE_DEPTH(sd);
			
			geneCallMethod=rs.getString("GENE_CALLING_METHOD");
			s.setGENE_CALLING_METHOD(geneCallMethod);
			
			contigCounts=rs.getString("CONTIG_COUNT");
			int cc=0;
			try{
				cc=Integer.valueOf(contigCounts);
			}
			catch(Exception e){
				cc=0;
			}
			s.setCONTIG_COUNT(cc);
			
			sizeKB=rs.getString("SIZE_KB");
			
			orfs=rs.getString("ORFS");
			int gcf=0;
			try{
				gcf=Integer.valueOf(orfs);
			}
			catch(Exception e){
				gcf=0;
			}
			s.setGENE_COUNT_ORF(gcf);
			
			chloromoseCount=rs.getString("CHROMOSOME_COUNT");
			plasmidCounts=rs.getString("PLASMID_COUNT");
			
			gcContent=rs.getString("GC_CONTENT");
			
			double gc=0;
			try{
				gc=Double.valueOf(gcContent);
			}
			catch(Exception e){
				gc=0.0;
			}
			s.setGC_PERCENTAGE(gc);
			
			sequenceMethod=rs.getString("SEQUENCING_METHOD");
		
			sequenceCountry=rs.getString("SEQUENCING_COUNTRY");
			s.setSEQUENCING_COUNTRY(sequenceCountry);
			
			s.updateSequencing(conn);
			
			IsolateLocation location=new IsolateLocation(conn, organism.getORGANISM_ID());
			isolationSite=rs.getString("ISOLATION_SITE");			
			isolationSource=rs.getString("ISOLATION_SOURCE");
			isolationComments=rs.getString("ISOLATION_COMMENTS");
			collectionDate=rs.getString("COLLECTION_DATE");
			isolationCountry=rs.getString("ISOLATION_COUNTRY");		
			location.setCOUNTRY(isolationCountry);
			
			rs.getString("ISOLATION_PUBMED_ID");
			geographLocation=rs.getString("GEOGRAPHIC_LOCATION");
			
			
			latitute=rs.getString("LATITUDE");
			location.setLATITUDE(latitute);
			
			longitude=rs.getString("LONGITUDE");
			location.setLONGITUDE(longitude);
			
			altitude=rs.getString("ALTITUDE");
			location.setALTITUDE(altitude);
			
			depeth=rs.getString("DEPTH");
			location.setDEPTH(depeth);
			location.updateIsolateLocation(conn);
			
			Host host=new Host(conn);
			
			hostName=rs.getString("HOST_NAME");
			host.setHostName(hostName);
			
			hosttaxonID=rs.getString("HOST_TAXON_ID");
			int htid=0;
			try{
				htid=Integer.valueOf(hosttaxonID);
			}
			catch(Exception e){
				htid=0;
			}
			host.setTAXONID(htid);
			
			hostGender=rs.getString("HOST_GENDER");
			host.setGENDER(hostGender);
			
			hostAge=rs.getString("HOST_AGE");
			host.setAGE(hostAge);
			
			hostRace=rs.getString("HOST_RACE");
			
			hostHealth=rs.getString("HOST_HEALTH");
			host.setHEALTH(hostHealth);
			
			hostmedication=rs.getString("HOST_MEDICATION");
			hostSpecificity=rs.getString("HOST_SPECIFICITY");
			bodySampleSite=rs.getString("BODY_SAMPLE_SITE");
			
			host.setBODY_SITE(bodySampleSite);
			
			bodyProduct=rs.getString("BODY_PRODUCT");
			bodysampleSubSite=rs.getString("BODY_SAMPLE_SUBSITE");
			host.setBODY_SAMPLE_SUBSITE(bodysampleSubSite);
			
			hostComments=rs.getString("HOST_COMMENTS");
				
			host.updateHost(conn);
		
			OrganismHost oh=new OrganismHost(organism.getORGANISM_ID(), host.getHOST_ID());
			oh.updateOrganismHost(conn);
			
			System.out.println(genus+"\t"+ orgName+"\t"+ species);
		}
		System.out.println("END updating ");
		conn.commit();
		conn.close();
		}catch(SQLException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String updateString(String s){
		
		String t=s.replaceAll("'", "");
		String temp=t.replaceAll("\"", "");
		return temp;
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		
			GOLDData gold=new GOLDData();
			gold.updateTables();
		
	}

}
