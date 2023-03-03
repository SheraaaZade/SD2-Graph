import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatriceDAdjacence extends Graph {

  private Map<Integer, Airport> correspondanceIndiceAirport;
  private Map<Airport, Integer> correspondanceAirportIndice;
  private Flight[][] matrice = new Flight[0][0];
  private int nbAirport = 0;

  public MatriceDAdjacence() {
    super();
    correspondanceAirportIndice = new HashMap<Airport, Integer>();
    correspondanceIndiceAirport = new HashMap<Integer, Airport>();
  }

  @Override
  // Complexité: o(n²)
  protected void ajouterSommet(Airport a) {
    //à compléter
    if (nbAirport >= matrice.length) {
      Flight[][] tab = new Flight[nbAirport + 5][nbAirport + 5];
      for (int i = 0; i < matrice.length; i++) {
        for (int j = 0; j < matrice[i].length; j++) {
          tab[i][j] = matrice[i][j];
        }
      }
      matrice = tab;
    }
    correspondanceIndiceAirport.put(nbAirport, a);
    correspondanceAirportIndice.put(a, nbAirport);
    nbAirport++;
  }

  @Override
  // Complexité: ?
  protected void ajouterArc(Flight f) {
    //à compléter
    matrice[correspondanceAirportIndice.get(f.getSource())]
        [correspondanceAirportIndice.get(f.getDestination())] = f;
  }

  @Override
  //  Complexité: ?
  public Set<Flight> arcsSortants(Airport a) {
    //à compléter
    return null;
  }

  @Override
  // Complexité: ?
  public boolean sontAdjacents(Airport a1, Airport a2) {
    // à compléter
    return false;
  }


}
