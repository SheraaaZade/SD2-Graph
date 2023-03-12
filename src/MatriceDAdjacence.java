import java.util.HashMap;
import java.util.HashSet;
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
//    if (nbAirport >= matrice.length) {
//      Flight[][] tab = new Flight[nbAirport + 5][nbAirport + 5];
//      for (int i = 0; i < matrice.length; i++) {
//        for (int j = 0; j < matrice[i].length; j++) {
//          tab[i][j] = matrice[i][j];
//        }
//      }
//      matrice = tab;
//    }
//    correspondanceIndiceAirport.put(nbAirport, a);
//    correspondanceAirportIndice.put(a, nbAirport);
//    nbAirport++;
    correspondanceAirportIndice.put(a, nbAirport);
    correspondanceIndiceAirport.put(nbAirport, a);
    nbAirport++;
    Flight[][] newFlights = new Flight[nbAirport][nbAirport];
    for (int i = 0; i < nbAirport - 1; i++) {
      for (int j = 0; j < nbAirport - 1; j++) {
        newFlights[i][j] = matrice[i][j];
      }
    }
    matrice = newFlights;
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
    Set<Flight> set = new HashSet<>();

    for (int j = 0; j < matrice[correspondanceAirportIndice.get(a)].length; j++) {
      if (matrice[correspondanceAirportIndice.get(a)][j] != null) {
        set.add(matrice[correspondanceAirportIndice.get(a)][j]);
      }
    }
    return set;
  }

  @Override
  // Complexité: ?
  public boolean sontAdjacents(Airport a1, Airport a2) {
    // à compléter
    return matrice[correspondanceAirportIndice.get(a1)][correspondanceAirportIndice.get(a2)] != null
        || matrice[correspondanceAirportIndice.get(a2)][correspondanceAirportIndice.get(a1)]
        != null;
  }


}
