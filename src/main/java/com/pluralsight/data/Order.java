package com.pluralsight.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("order")
public class Order {
  @Value("#{50 + 200}")
  private double amount;
  @Value("#{order.amount >= 100 ? order.amount * .05 : 0}")
  private double discount;
  @Value("#{user.country == 'US' ? 3 : 14}")
  private int daysToDeliver;
  @Value("#{user.country}")
  private String origin;
//  @Value("#{T(java.text.NumberFormat).getCurrencyInstance(T(java.util.Locale).getDefault()).format(order.amount)}")
  private String formattedAmount;

  public String getFormattedAmount() {
    return formattedAmount;
  }

  public void setFormattedAmount(String formattedAmount) {
    this.formattedAmount = formattedAmount;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public int getDaysToDeliver() {
    return daysToDeliver;
  }

  public void setDaysToDeliver(int daysToDeliver) {
    this.daysToDeliver = daysToDeliver;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }
}
