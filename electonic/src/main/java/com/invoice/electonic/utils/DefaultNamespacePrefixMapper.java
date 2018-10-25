package com.invoice.electonic.utils;

import java.util.HashMap;
import java.util.Map;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
 
/**
 * Implementation of {@link NamespacePrefixMapper} that maps the schema
 * namespaces more to readable names. Used by the jaxb marshaller. Requires
 * setting the property "com.sun.xml.bind.namespacePrefixMapper" to an instance
 * of this class.
 * <p>
 * Requires dependency on JAXB implementation jars
 * </p>
 */
public class DefaultNamespacePrefixMapper extends NamespacePrefixMapper {
	
	// NameSpaces
		private static final String APP_RESP_URI = "urn:oasis:names:specification:ubl:schema:xsd:ApplicationResponse-2";
		private static final String CBC_URI = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2";
		private static final String CAC_URI = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2";
		private static final String FE_URI = "http://www.dian.gov.co/contratos/facturaelectronica/v1";
		private static final String EXT_URI = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2";
		private static final String STS_URI = "http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures";
		private static final String DS_URI = "http://www.w3.org/2000/09/xmldsig#";
		private static final String XADES_URI = "http://uri.etsi.org/01903/v1.3.2#";
		private static final String XADES141_URI = "http://uri.etsi.org/01903/v1.4.1#";
		
		
		
		// Prefijos
		private static final String APP_RESP_PREFIX = "n1";
		private static final String CBC_PREFIX = "cbc";
		private static final String CAC_PREFIX = "cac";
		private static final String FE_PREFIX = "fe";
		private static final String EXT_PREFIX = "ext";
		private static final String STS_PREFIX = "sts";
		private static final String DS_PREFIX = "ds";
		private static final String XADES_PREFIX = "xades";
		private static final String XADES141_PREFIX = "xades141";
		
 
	private Map<String, String> namespaceMap = new HashMap<>();
 
	/**
	 * Create mappings.
	 */
	public DefaultNamespacePrefixMapper() {
		namespaceMap.put(APP_RESP_URI,APP_RESP_PREFIX);
		namespaceMap.put(CBC_URI,CBC_PREFIX);
		namespaceMap.put(CAC_URI,CAC_PREFIX);
		namespaceMap.put(FE_URI,FE_PREFIX);
		namespaceMap.put(EXT_URI,EXT_PREFIX);
		namespaceMap.put(STS_URI,STS_PREFIX);
		namespaceMap.put(DS_URI,DS_PREFIX);
		namespaceMap.put(XADES_URI,XADES_PREFIX);
		namespaceMap.put(XADES141_URI,XADES141_PREFIX);
		
	}
 
	/* (non-Javadoc)
	 * Returning null when not found based on spec.
	 * @see com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
		return namespaceMap.getOrDefault(namespaceUri, suggestion);
	}
}