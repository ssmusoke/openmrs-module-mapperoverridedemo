package org.openmrs.module.mapperoverridedemo.fragment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ui.framework.fragment.FragmentRequest;
import org.openmrs.ui.framework.fragment.FragmentRequestMapper;
import org.springframework.stereotype.Component;

/**
 * Overrides the header page of the reference application
 */
@Component
public class DemoHeaderFragmentRequestMapper implements FragmentRequestMapper {

	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * Implementations should call {@link FragmentRequest#setProviderNameOverride(String)} and
	 * {@link FragmentRequest#setFragmentIdOverride(String)}, and return true if they want to remap a request,
	 * or return false if they didn't remap it.
	 *
	 * @param request may have its providerNameOverride and pageNameOverride set
	 * @return true if this page was mapped (by overriding the provider and/or page), false otherwise
	 */
	public boolean mapRequest(FragmentRequest request) {
		log.info(request.toString());
		if (request.getProviderName().equals("appui")) {
			if (request.getFragmentId().equals("header")) {
				// change to the custom login provided by the module
				request.setProviderNameOverride("mapperoverridedemo");
				request.setFragmentIdOverride("demoHeader"); // no need to specify this if the name of the fragment is the same as the one being over
				log.info(request.toString());
			}
		}
		return true;
	}
	
}
