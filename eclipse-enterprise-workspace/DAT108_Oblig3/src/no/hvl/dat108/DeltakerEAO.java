package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DeltakerEAO {

	@PersistenceContext(name = "deltakerPU")
	private EntityManager em;

	public synchronized void leggTilDeltaker(Deltaker deltaker) {
		em.persist(deltaker);
	}

	public Deltaker hentDeltakerPaaPK(int mobilnr) {
		return (Deltaker) em.find(Deltaker.class, mobilnr);
	}
	
	
	public List<Deltaker> hentAlleDeltakere() {

		List<Deltaker> deltakere = null;
		TypedQuery<Deltaker> query = em.createQuery("SELECT e FROM Deltaker e", Deltaker.class);
		deltakere = query.getResultList();

		return deltakere;
		
		
	}
	
	
}
