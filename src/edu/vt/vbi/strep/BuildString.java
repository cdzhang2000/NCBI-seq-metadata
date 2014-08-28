package edu.vt.vbi.strep;

import java.sql.Connection;
import java.util.StringTokenizer;

public class BuildString {
	
	
	public BuildString() {
	
	}
	
	public static void printString(String headers){
		
		StringBuffer  sql=new StringBuffer();
		
		StringTokenizer st=new StringTokenizer(headers, "\t");
		String temp="";
		
		while(st.hasMoreElements()){
		temp=st.nextToken().trim();
		temp=temp.replaceAll(" ", "_");
		sql.append(temp+" varchar2(4000),\n");	
		}		
		sql.append(")");
		
		System.out.println(sql.toString());
	}
	
public static void printString2(String headers){
		
		StringBuffer  sql=new StringBuffer();
		
		StringTokenizer st=new StringTokenizer(headers, "\t");
		String temp="";
		int c=0;	
		while(st.hasMoreElements()){
		temp=st.nextToken().trim();
		c++;
		sql.append("GENOME"+c+ " \"TRIM(:"+temp+")\",\n");	
		}				
		System.out.println(sql.toString());
	}
	
	public static void replace(String s, int startNumber, String prefix){
		
		StringBuffer  sql=new StringBuffer();
		
		StringTokenizer st=new StringTokenizer(s, "\t");
		String temp="";		
		int c=0;
		while(st.hasMoreElements()){			
		temp=st.nextToken();
		sql.append(prefix);
		sql.append(startNumber+"\t");
		startNumber++;
		c++;
		System.out.println(temp);
		}
		System.out.println("total no= "+c);
		System.out.println(sql.toString());
		
	}
	
	
public static void replaceAllColumnName(String s, int startNumber, String prefix){
		
		StringBuffer  sql=new StringBuffer();
		
		StringTokenizer st=new StringTokenizer(s, "\t");
		String temp="";		
		int c=0;
		while(st.hasMoreElements()){			
		temp=st.nextToken();
		sql.append(prefix);
		sql.append(startNumber+"\t varchar2(4000),\n");
		startNumber++;
		c++;
		//System.out.println(temp);
		}
		System.out.println("total no= "+c);
		System.out.println(sql.toString());
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String f="genome1	genome2	genome3	genome4	genome5	genome6	genome7	genome8	genome9	genome10	genome11	genome12	genome13	genome14	genome15	genome16	genome17	genome18	genome19	genome20	genome21	genome22	genome23	genome24	genome25	genome26	genome27	genome28	genome29	genome30	genome31	genome32	genome33	genome34	genome35	genome36	genome37	genome38	genome39	genome40	genome41	genome42	genome43	genome44	genome45	genome46	genome47	genome48	genome49	genome50	genome51	genome52	genome53	genome54	genome55	genome56	genome57	genome58	genome59	genome60	genome61	genome62	genome63	genome64	genome65	genome66	genome67	genome68	genome69	genome70	genome71	genome72	genome73	genome74	genome75	genome76	genome77	genome78	genome79	genome80	genome81	genome82	genome83	genome84	genome85	genome86	genome87	genome88	genome89	genome90	genome91	genome92	genome93	genome94	genome95	genome96	genome97	genome98	genome99	genome100	genome101	genome102	genome103	genome104	genome105	genome106	genome107	genome108	genome109	genome110	genome111	genome112	genome113	genome114	genome115	genome116	genome117	genome118	genome119	genome120	genome121	genome122	genome123	genome124	genome125	genome126	genome127	genome128	genome129	genome130	genome131	genome132	genome133	genome134	genome135	genome136	genome137	genome138	genome139	genome140	genome141	genome142	genome143	genome144	genome145	genome146	genome147	genome148	genome149	genome150	genome151	genome152	genome153	genome154	genome155	genome156	genome157	genome158	genome159	genome160	genome161	genome162	genome163	genome164	genome165	genome166	genome167	genome168	genome169	genome170	genome171	genome172	genome173	genome174	genome175	genome176	genome177	genome178	genome179	genome180	genome181	genome182	genome183	genome184	genome185	genome186	genome187	genome188	genome189	genome190	genome191	genome192	genome193	genome194	genome195	genome196	genome197	genome198	genome199	genome200	genome201	genome202	genome203	genome204	genome205	genome206	genome207	genome208	genome209	genome210	genome211	genome212	genome213	genome214	genome215	genome216	genome217	genome218	genome219	genome220	genome221	genome222	genome223	genome224	genome225	genome226	genome227	genome228	genome229	genome230	genome231	genome232	genome233	genome234	genome235	genome236	genome237	genome238	genome239	genome240	genome241	genome242	genome243	genome244	genome245	genome246	genome247	genome248	genome249	genome250	genome251	genome252	genome253	genome254	genome255	genome256	genome257	genome258	genome259	genome260	genome261	genome262	genome263	genome264	genome265	genome266	genome267	genome268	genome269	genome270	genome271	genome272	genome273	genome274	genome275	genome276	genome277	genome278	genome279	genome280	genome281	genome282	genome283	genome284	genome285	genome286	genome287	genome288	genome289	genome290	genome291	genome292	genome293	genome294	genome295	genome296	genome297	genome298	genome299	genome300	genome301	genome302	genome303	genome304	genome305	genome306	genome307	genome308	genome309	genome310	genome311	genome312	genome313	genome314	genome315	genome316	genome317	genome318	genome319	genome320	genome321	genome322	genome323	genome324	genome325	genome326	genome327	genome328	genome329	genome330	genome331	genome332	genome333	genome334	genome335	genome336	genome337	genome338	genome339	genome340	genome341	genome342	genome343	genome344	genome345	genome346	genome347	genome348	genome349	genome350	genome351	genome352	genome353	genome354	genome355	genome356	genome357	genome358	genome359	genome360	genome361	genome362	genome363	genome364	genome365	genome366	genome367	genome368	genome369	genome370	genome371	genome372	genome373	genome374	genome375	genome376	genome377	genome378	genome379	genome380	genome381	genome382	genome383";
		
		//BuildString.printString(f);
		
		//String f2="";
		BuildString.printString2(f);
		//BuildString.replace(f, 1, "GENOME");
		//BuildString.replaceAllColumnName(f, 1, "GENOME");
		
	}

}
