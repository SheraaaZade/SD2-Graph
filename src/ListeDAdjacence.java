import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListeDAdjacence extends Graph {

	private Map<Airport, Set<Flight>> outputFlights;

	public ListeDAdjacence() {
		super();
		outputFlights = new HashMap<Airport, Set<Flight>>();
	}

	@Override
	// Complexit�: o(1)
	protected void ajouterSommet(Airport a) {
		outputFlights.put(a, new HashSet<Flight>());
	}

	@Override
	// Complexit�: o(1)
	protected void ajouterArc(Flight f) {
		outputFlights.get(f.getSource()).add(f);
	}

	@Override
	// Complexit�: o(n)
	public Set<Flight> arcsSortants(Airport a) {
		for (Airport airport : outputFlights.keySet()) {
			if (airport.equals(a))
				return outputFlights.get(airport);
		}
		return null;
	}

	@Override
	// Complexit�: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		for (Flight flight : outputFlights.get(a1)) {
			if (flight.getDestination().equals(a2))
				return true;
		}
		for (Flight flight : outputFlights.get(a2)) {
			if (flight.getDestination().equals(a1))
				return true;
		}
		return false;
	}

}
