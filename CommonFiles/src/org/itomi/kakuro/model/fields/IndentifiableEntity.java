package org.itomi.kakuro.model.fields;

import java.util.UUID;
/**
 * Klasa bazowa odpowiedzialna za jednoznacznie indentyfikowanie obiektow ja rozszerzajacych.
 * 
 * @author Hertz
 *
 */
public abstract class IndentifiableEntity {
	private UUID uuid = UUID.randomUUID();
	
	/**
	 * Zwraca niemutowalny obiekt {@link UUID} tego obiektu
	 * @return
	 */
	public UUID getUuid() {
		return uuid;
	}
}
