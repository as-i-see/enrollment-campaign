package ua.thydope.finalproject.component.account;

public enum AccountType {
  GUEST(-1), USER(2), ADMIN(1);

  private int index;

  AccountType(int tableIndex) {
    this.index = tableIndex;
  }

  public int getIndex() {
    return index;
  }
}
