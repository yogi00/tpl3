package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdaper extends ThirdPartyDoor implements Door{

	@Override
	public void open(String code) throws IncorrectDoorCodeException {
		if (!isOpen()){
			try {
				unlock(code);
				setState(DoorState.OPEN);
			} catch (CannotUnlockDoorException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new IncorrectDoorCodeException();
			} catch (CannotChangeStateOfLockedDoor e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void close() {
		if(isOpen()){
			try {
				setState(DoorState.CLOSED);
				lock();
			} catch (CannotChangeStateOfLockedDoor e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean isOpen() {
		return DoorState.OPEN.equals(getState());
	}

	@Override
	public void changeCode(String oldCode, String newCode,
			String newCodeConfirmation) throws IncorrectDoorCodeException,
			CodeMismatchException {
		try {
			unlock(oldCode);
		} catch (CannotUnlockDoorException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new IncorrectDoorCodeException();
		}
		if(!newCode.equals(newCodeConfirmation)) 
			throw new CodeMismatchException();
		try {
			setNewLockCode(newCode);
			lock();
		} catch (CannotChangeCodeForUnlockedDoor e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			new IncorrectDoorCodeException();
		}
		
		
	}

	@Override
	public boolean testCode(String code) {
		try {
			unlock(code);
			lock();
		} catch (CannotUnlockDoorException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		return true;
	}

}
