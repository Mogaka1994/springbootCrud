/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogaka.polycarp.Repository;

import com.mogaka.polycarp.entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author moha
 */
@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long>{

}
