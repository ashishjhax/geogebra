package org.geogebra.web.html5.export;

import org.geogebra.common.util.debug.Log;
import org.geogebra.web.html5.js.ResourcesInjector;
import org.geogebra.web.html5.util.ScriptLoadCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ScriptElement;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "window")
public final class ExportLoader {

	private ExportLoader() {
		// utility class
	}

	@JsProperty(name = "C2S")
	public static native Object getCanvas2Svg();

	@JsProperty(name = "canvas2pdf")
	public static native Object getCanvas2Pdf();

	@JsProperty(name = "gifshot")
	public static native Gifshot getGifshot();

	@JsProperty(name = "WebMGL")
	public static native Object getWhammy();

	/**
	 * @param callback to be executed when canvas2svg is loaded
	 */
	@JsOverlay
	public static void onCanvas2SvgLoaded(Runnable callback) {
		if (getCanvas2Svg() != null) {
			callback.run();
		} else {
			load(callback, "canvas2svg");
		}
	}

	/**
	 * @param callback to be executed when canvas2pdf is loaded
	 */
	@JsOverlay
	public static void onCanvas2PdfLoaded(Runnable callback) {
		if (getCanvas2Pdf() != null) {
			callback.run();
		} else {
			load(callback, "canvas2pdf");
		}
	}

	/**
	 * @param callback to be executed when gifshot is loaded
	 */
	@JsOverlay
	public static void onGifshotLoaded(Runnable callback) {
		if (getGifshot() != null) {
			callback.run();
		} else {
			load(callback, "gifshot");
		}
	}

	/**
	 * @param callback to be executed when whammy is loaded
	 */
	@JsOverlay
	public static void onWhammyLoaded(Runnable callback) {
		if (getWhammy() != null) {
			callback.run();
		} else {
			load(callback, "whammy");
		}
	}

	@JsOverlay
	private static void load(Runnable callback, String name) {
		ScriptElement scriptElement = Document.get().createScriptElement();
		scriptElement.setSrc(GWT.getModuleBaseURL() + "js/" + name + ".min.js");
		ScriptLoadCallback loadCallback = new ScriptLoadCallback() {
			@Override
			public void onLoad() {
				Log.debug(name + " loaded");
				callback.run();
			}

			@Override
			public void onError() {
				Log.error(name + " failed to load");
			}

			@Override
			public void cancel() {
				// only for localization files
			}
		};
		ResourcesInjector.loadJS(scriptElement, loadCallback);
	}
}
