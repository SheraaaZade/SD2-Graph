import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListeDArc extends Graph{

	private ArrayList<Flight> flights;

	public ListeDArc() {
		super();
		flights=new ArrayList<Flight>();
	}

	@Override
	// Complexit�: o()
	protected void ajouterSommet(Airport a) {
		// on ne retient pas de vol ; donc elle reste vide
	}

	@Override
	// Complexit�: o(1)
	protected void ajouterArc(Flight f) {
		flights.add(f);
	}

	@Override
	// Complexit�: o(m) car m c'est le nombre d'arcs
	public Set<Flight> arcsSortants(Airport a) {
		//� compl�ter
		Set<Flight> ensemble = new HashSet<Flight>();
		for (Flight flight : flights) {
			if(flight.getSource().equals(a))
				ensemble.add(flight);
		}
		return ensemble;
	}

	@Override
	// Complexit�: o(n)
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// � compl�ter
		for (Flight flight : flights) {
			if((flight.getSource().equals(a1) && flight.getDestination().equals(a2))
					|| (flight.getSource().equals(a2) && flight.getDestination().equals(a1)))
				return true;
		}
		return false;
	}

}
