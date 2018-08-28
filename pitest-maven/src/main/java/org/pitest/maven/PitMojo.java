package org.pitest.maven;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Goal which runs a coverage mutation report
 */
@Mojo(name = "mutationCoverage", defaultPhase = LifecyclePhase.VERIFY, requiresDependencyResolution = ResolutionScope.TEST)
public class PitMojo extends AbstractPitMojo {

    // Concrete List types declared for all fields to work around maven 2 bug
    /**
   * Classes to include in mutation test
   *
   * @parameter expression="${targetClasses}"
   *
   */
    /**
   * Tests to run
   *
   * @parameter expression="${targetTests}"
   *
   */
    /**
   * Methods not to mutate
   *
   * @parameter expression="${excludedMethods}"
   *
   */
    /**
   * Classes not to mutate or run tests from
   *
   * @parameter expression="${excludedClasses}"
   *
   */
    /**
   *
   * @parameter expression="${avoidCallsTo}"
   *
   */
    /**
   * Base directory where all reports are written to.
   *
   * @parameter default-value="${project.build.directory}/pit-reports"
   *            expression="${reportsDirectory}"
   */
    /**
   * File to write history information to for incremental analysis
   *
   * @parameter expression="${historyOutputFile}"
   */
    /**
   * File to read history from for incremental analysis (can be same as output
   * file)
   *
   * @parameter expression="${historyInputFile}"
   */
    /**
   * Convenience flag to read and write history to a local temp file.
   * 
   * Setting this flag is the equivalent to calling maven with -DhistoryInputFile=file -DhistoryOutputFile=file
   * 
   * Where file is a file named [groupid][artifactid][version]_pitest_history.bin in the temp directory
   * 
   * @parameter default-value="false" expression="${withHistory}"
   */
    private boolean withHistory;

    /**
   * Maximum distance to look from test to class. Relevant when mutating static
   * initializers
   *
   * @parameter default-value="-1" expression="${maxDependencyDistance}"
   */
    /**
   * Number of threads to use
   *
   * @parameter default-value="1" expression="${threads}"
   */
    /**
   * Mutate static initializers
   *
   * @parameter default-value="false" expression="${mutateStaticInitializers}"
   */
    /**
   * Detect inlined code
   *
   * @parameter default-value="true" expression="${detectInlinedCode}"
   */
    /**
   * Mutation operators to apply
   *
   * @parameter expression="${mutators}"
   */
    /**
   * Weighting to allow for timeouts
   *
   * @parameter default-value="1.25" expression="${timeoutFactor}"
   */
    /**
   * Constant factor to allow for timeouts
   *
   * @parameter default-value="3000" expression="${timeoutConstant}"
   */
    /**
   * Maximum number of mutations to allow per class
   *
   * @parameter default-value="-1" expression="${maxMutationsPerClass}"
   */
    /**
   * Arguments to pass to child processes
   *
   * @parameter
   */
    /**
   * Formats to output during analysis phase
   *
   * @parameter expression="${outputFormats}"
   */
    /**
   * Output verbose logging
   *
   * @parameter default-value="false" expression="${verbose}"
   */
    /**
   * Throw error if no mutations found
   *
   * @parameter default-value="true" expression="${failWhenNoMutations}"
   */
    /**
   * Create timestamped subdirectory for report
   *
   * @parameter default-value="true" expression="${timestampedReports}"
   */
    /**
   * TestNG Groups/JUnit Categories to exclude
   *
   * @parameter expression="${excludedGroups}"
   */
    /**
   * TestNG Groups/JUnit Categories to include
   *
   * @parameter expression="${includedGroups}"
   */
    /**
   * Maximum number of mutations to include in a single analysis unit.
   *
   * @parameter expression="${mutationUnitSize}"
   */
    /**
   * Export line coverage data
   *
   * @parameter default-value="false" expression="${exportLineCoverage}"
   */
    /**
   * Mutation score threshold at which to fail build
   *
   * @parameter default-value="0" expression="${mutationThreshold}"
   */
    /**
   * Line coverage threshold at which to fail build
   *
   * @parameter default-value="0" expression="${coverageThreshold}"
   */
    /**
   * Path to java executable to use when running tests. Will default to
   * executable in JAVA_HOME if none set.
   *
   * @parameter
   */
    /**
   * Engine to use when generating mutations.
   *
   * @parameter default-value="gregor" expression="${mutationEngine}"
   */
    /**
   * List of additional classpath entries to use when looking for tests and
   * mutable code. These will be used in addition to the classpath with which
   * PIT is launched.
   *
   * @parameter expression="${additionalClasspathElements}"
   */
    /**
   * List of classpath entries, formatted as "groupId:artifactId", which should
   * not be included in the classpath when running mutation tests. Modelled
   * after the corresponding Surefire/Failsafe property.
   *
   * @parameter expression="${classpathDependencyExcludes}"
   */
    /**
   * When set indicates that analysis of this project should be skipped
   *
   * @parameter default-value="false"
   */
    /**
   * When set will try and create settings based on surefire configuration. This
   * may not give the desired result in some circumstances
   *
   * @parameter default-value="true"
   */
    /**
   * honours common skipTests flag in a maven run
   *
   * @parameter default-value="false"
   */
    /**
   * Use slf4j for logging
   *
   * @parameter default-value="false" expression="${useSlf4j}"
   */
    /**
   * Configuration properties.
   *
   * Value pairs may be used by pitest plugins.
   *
   * @parameter
   */
    /**
   * environment configuration
   *
   * Value pairs may be used by pitest plugins.
   *
   * @parameter
   */
    /**
   * <i>Internal</i>: Project to interact with.
   *
   * @parameter expression="${project}"
   * @required
   * @readonly
   */
    /**
   * <i>Internal</i>: Map of plugin artifacts.
   *
   * @parameter expression="${plugin.artifactMap}"
   * @required
   * @readonly
   */
    public boolean useHistory() {
        return this.withHistory;
    }
}
