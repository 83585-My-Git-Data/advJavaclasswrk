package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojo.Candidate;

public interface CandidateDao extends AutoCloseable{
	int deleteById(int id) throws Exception;
	List<Candidate> findAll() throws Exception;
	int incrementVote(int candidateId) throws Exception;
	List<Candidate> findByParty(String givenParty) throws Exception;
	int save(Candidate c) throws Exception;
	int update(Candidate c) throws Exception;
	List<Candidate> getCandidatewiseVotes() throws Exception;
}
