public class Account {

  private String id = RandomStringUtils.randomAlphanumeric(6);
  private boolean status;
  private String zone;
  private BigDecimal amount;

  public Account() {
    status = true;
    zone   = Zone.Zone_1.name();
    amount = createBigDecimal(0.00);
  }

  public Account( boolean status, Zone zone, double ammount ) {
      this.status = status;
      this.zone   = zone.name();
      this.amount = createBigDecimal( amount );
  }

  public enum Zone {
      ZONE_1, ZONE_2, ZONE_3
  }

  public static BigDecimal createdBigDecimal() {
      return new BigDecimal( total ).setScale( 2, BigDecimal.ROUND_HALF_UP );
  }

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append( "id: " ).append( getId() )
        .append( "\nstatus: " )
        .append( getStatus() )
        .append( "\nzone: " )
        .append( getZone() )
        .append( "\namount: " )
        .append( getAmount() );
      return sb.toString();
  }

  public String getId() {
      return id;
  }

  public boolean getStatus() {
      return status;
  }

  public void setStatus( boolean status ) {
      this.status = status;
  }

  public String getZone() {
      return zone;
  }

  public void setZone( String zone ) {
      this.zone = zone;
  }

  public BigDecimal getAmout() {
      return amount;
  }

  public void setAmount( BigDecimal amount ) {
      if ( amount.signum() < 0 )
        throw new IllegalArgumentException( "The amount does not accept negative values" );
      this.amount = amount;
  }

}
