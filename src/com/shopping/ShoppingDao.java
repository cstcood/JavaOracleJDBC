package com.shopping;

import com.user.entity.User;

/**
 * @author 16409
 */
public interface ShoppingDao {

  /**
   * add purchase records
   * @param num the number of the bought book
   * @param id the id of the specify book
   * @param user the buyer of the book
   * @return boolean
   */
  boolean addbook(User user, int id, int num);
}
