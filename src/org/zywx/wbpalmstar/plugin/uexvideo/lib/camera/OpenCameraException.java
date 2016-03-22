package org.zywx.wbpalmstar.plugin.uexvideo.lib.camera;

import org.zywx.wbpalmstar.plugin.uexvideo.lib.CLog;

public class OpenCameraException extends Exception {

	private static final String	LOG_PREFIX			= "Unable to open camera - ";
	private static final long	serialVersionUID	= -7340415176385044242L;

	public enum OpenType {
		INUSE("Camera disabled or in use by other process"), NOCAMERA("Device does not have camera");

		private String	mMessage;

		private OpenType(String msg) {
			mMessage = msg;
		}

		public String getMessage() {
			return mMessage;
		}

	}

	private final OpenType	mType;

	public OpenCameraException(OpenType type) {
		super(type.getMessage());
		mType = type;
	}

	@Override
	public void printStackTrace() {
		CLog.e(CLog.EXCEPTION, LOG_PREFIX + mType.getMessage());
		super.printStackTrace();
	}
}
