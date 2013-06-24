/**
 * 
 */
package com.saba.process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.saba.model.CSu;
import com.saba.model.CSuv;
import com.saba.model.CSuvw;
import com.saba.model.U;
import com.saba.model.Uv;
import com.saba.model.Uvw;
import com.saba.translation.CSuRepository;
import com.saba.translation.CSuvRepository;
import com.saba.translation.CSuvwRepository;
//import javax.persistence.Query;

/**
 * @author rpuduppully
 *
 */
public class SpanishLanguageModel {

	private static final String TRAINING_FILE = "D:/project/study/nlp/h3/corpus.es";
//	private static final String TRAINING_FILE = "/home/arya/nlp/h3/dev.en";
	private static final String STAR = "@#!@#!@#!";
	private static final String STOP_SYMBOL ="^&%$%$^$&^&";
	private static final String SPACE = " "; 
//	private Map<Uvw,Integer> cuvw = new HashMap<Uvw,Integer>();
//	private Map<Uv,Integer> cuv = new HashMap<Uv,Integer>();
//	private Map<U,Integer> cu = new HashMap<U,Integer>();
//	private Map<Uvw,Float> qwgivenuv = new HashMap<Uvw,Float>();
//	private Map<Uv,Float> qwgivenv = new HashMap<Uv,Float>();
//	private Map<U,Float> qw = new HashMap<U,Float>();
	private final static int total =159237;
	@Autowired
	private CSuvwRepository csuvwRepository;
	@Autowired
	private CSuvRepository csuvRepository;
	@Autowired
	private CSuRepository csuRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	/**
	 * @param args
	 */
	public void process() {
		readTrainingData();
	}
	
	public static void main(String[] args) {
		SpanishLanguageModel languageModel = new SpanishLanguageModel();
//		languageModel.countTotal();
	}

/*	public void countTotal() {
		try{
			BufferedReader br1 = new BufferedReader(new FileReader(TRAINING_FILE));
			String inputLine = null;
			while((inputLine = br1.readLine())!=null){
				String[] inputLineArgs = inputLine.split(SPACE);
				total += inputLineArgs.length;
			}
			br1.close();
			
			System.out.println("total "+total);
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
//	public Map<U, Integer> getCu() {
//		return cu;
//	}
//	
//	public Map<Uvw, Integer> getCuvw() {
//		return cuvw;
//	}
//	
//	public Map<Uv, Integer> getCuv() {
//		return cuv;
//	}
	
	public void readTrainingData() {
		try {
//			f.put
			BufferedReader br1 = new BufferedReader(new FileReader(TRAINING_FILE));
			String inputLine = null;
			while((inputLine = br1.readLine())!=null){
				String[] args = inputLine.split(SPACE);
				
//				Uv uv = new Uv(STAR, args[0]);
//				incrementValueCuv(cuv, uv);
//				Uvw uvw = new Uvw(STAR, STAR, args[0]);
//				incrementValueCuvw(cuvw, uvw);
//				uvw = new Uvw(STAR, args[1], args[2]);
//				incrementValueCuvw(cuvw, uvw);
//				total += args.length;
				String [] tokens = new String[args.length +3];
				tokens[0] = STAR;
				tokens[1] = STAR;
				tokens[tokens.length -1] = STOP_SYMBOL;
				System.arraycopy(args, 0, tokens, 2, args.length);
				for (int i = 2; i < tokens.length; i++) {
					String w = tokens[i];
					String u = tokens[i-2];
					String v = tokens[i-1];
					Uvw uvw = new Uvw(u, v, w);
					incrementValueCuvw(uvw);
					
					Uv uv = new Uv(v, w);
					incrementValueCuv(uv);
					
					U uobj = new U(w);
					incrementValueCu(uobj);
				}
			}
			br1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void incrementValueCu(U key) {
//		if(map.containsKey(key)){
//			map.put(key, map.get(key)+1);
//		}else{
//			map.put(key, 1);
//		}
		CSu csuInstance = find(key);
//		Cu cuInstance = cuRepository.find
		if(csuInstance != null){
			csuInstance.setC(csuInstance.getC()+1);
			csuRepository.save(csuInstance);
		}else{
			csuRepository.save(new CSu(key, 1));
		}
	}

	private CSu find(U key) {
		Query query = new Query();
		query.addCriteria(Criteria.where("u.u").is(key.getU()));
		CSu csuInstance = mongoTemplate.findOne(query, CSu.class);
		return csuInstance;
	}
	private void incrementValueCuvw( Uvw key) {
//		if(map.containsKey(key)){
//			map.put(key, map.get(key)+1);
//		}else{
//			map.put(key, 1);
//		}
//		Cuvw cuvwInstance =cuvwRepository.findOne(key);
		CSuvw csuvwInstance = find(key);

		if(csuvwInstance != null){
			csuvwInstance.setC(csuvwInstance.getC()+1);
			csuvwRepository.save(csuvwInstance);
		}else{
			csuvwRepository.save(new CSuvw(key,1));
		}
	}

	private CSuvw find(Uvw key) {
		Query query = new Query();
		query.addCriteria(Criteria.where("uvw.u").is(key.getU()).and("uvw.v").is(key.getV()).and("uvw.w").is(key.getW()));
		CSuvw csuvwInstance = mongoTemplate.findOne(query, CSuvw.class);
		return csuvwInstance;
	}
	private void incrementValueCuv(Uv key){
//		if(map.containsKey(key)){
//			map.put(key, map.get(key)+1);
//		}else{
//			map.put(key, 1);
//		}
		
		CSuv csuvInstance = find(key);

		if(csuvInstance != null){
			csuvInstance.setC(csuvInstance.getC()+1);
			csuvRepository.save(csuvInstance);
		}else{
			csuvRepository.save(new CSuv(key,1));
		}
	}

	private CSuv find(Uv key) {
		Query query = new Query();
		query.addCriteria(Criteria.where("uv.u").is(key.getU()).and("uv.v").is(key.getV()));
		CSuv csuvInstance = mongoTemplate.findOne(query, CSuv.class);
		return csuvInstance;
	}

	public float findq(String u, String v, String w){
		if(u.length()==0 && v.length()==0){
			u = STAR;
			v = STAR;
		}
		if(u.length() == 0){
			u  = STAR;
		}
		Uvw uvw = new Uvw(u, v, w);
		Uv uv = new Uv(v, w);
		U uObj = new U(w);
//		Integer countUvw = cuvw.get(uvw);
//		Integer countUv = cuv.get(uv);
//		Integer countU = cu.get(uObj);
		CSuvw cuvw = find(uvw);
		Integer countUvw = cuvw == null? 0: cuvw.getC();
		CSuv cuv = find(uv);
		Integer countUv = cuv == null? 0:cuv.getC();
		CSu countUObj = find(uObj);
		Integer countU = countUObj == null ? 0: countUObj.getC();
		
		float q = 0;
		if(countUv != null && countUvw != null  && countUv !=0){
			q+= (float)countUvw/countUv;
		}
		
		if(countU != null && countUv != null && countU !=0){
			q+= (float)countUv/countU;
		}
		
		q+= (float)countU/total;
		
		return q/3;
	}
}
