package com.ENTER.fillter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@Slf4j
@Component
public class XSSFilter extends OncePerRequestFilter  { // cf. OpenSessionInViewFilter 최대절전모드?? 쓰는게 맞나??? 추후고민
	static final Pattern STATIC_RESOURCES = Pattern.compile(
			"(^/resources/css/.*)|(^/resources/font/.*)|(^/resources/fonts/.*)|(^/resources/image/.*)|(^/resources/js/.*)|(^/resources/thirdparty/.*)" +
					"|(^/resources/ui/.*)");

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String path = request.getServletPath();
		log.debug(">>>>> path: {}", path);

		if (STATIC_RESOURCES.matcher(path).matches()) {
			log.debug(">>>>> static resources");
			filterChain.doFilter(request, response);
		} else {

			filterChain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);

		}
	}
}
