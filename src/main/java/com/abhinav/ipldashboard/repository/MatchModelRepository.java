package com.abhinav.ipldashboard.repository;

import com.abhinav.ipldashboard.entity.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchModelRepository extends JpaRepository<MatchModel,Long> {
}
