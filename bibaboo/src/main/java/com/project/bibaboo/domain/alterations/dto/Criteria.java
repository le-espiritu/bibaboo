package com.project.bibaboo.domain.alterations.dto;

// 페이징 쿼리를 동적 제어하기 위해 필요한 데이터를 보관하는 용도
public class Criteria {

  private int pageNum; // 현재 페이지
  private int amount; // 한 페이지당 보여질 데이터(게시물) 갯수
  private int startOffset; // offset이란 sql에서 조희를 시작할 기준점을 의미한다.

  public Criteria() {
    // 기본값 설정
    this.pageNum = 1; // pageNum이 넘어오지 않았을때, pageNum은 기본적으로 1값을 가진다.
    this.amount = 10;
    this.startOffset = 0; // (pageNum-1)*amount
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.startOffset = (pageNum - 1) * this.amount;
    this.pageNum = pageNum;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.startOffset = (this.pageNum - 1) * amount;
    this.amount = amount;
  }

  public int getStartOffset() {
    return startOffset;
  }

  public void setStartOffset(int startOffset) {
    this.startOffset = startOffset;
  }

  @Override
  public String toString() {
    return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", startOffset=" + startOffset
        + "]";
  }

}
