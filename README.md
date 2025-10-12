# Spring Boot SendGrid GreenMail Client

A Spring Boot application that demonstrates sending emails using SendGrid API with GreenMail for testing.

## Features

- Send emails using SendGrid API
- Mustache template support for email content
- Email validation
- GreenMail integration for testing
- RESTful API endpoint
- Comprehensive error handling

## Technologies

- **Spring Boot**: 3.5.6
- **Java**: 21
- **SendGrid**: 4.10.3
- **GreenMail**: 2.1.7 (for testing)
- **Mustache**: Template engine for emails
- **Lombok**: Reduce boilerplate code
- **ModelMapper**: 3.2.5

## Requirements

- Java 21 or higher
- Maven 3.x
- SendGrid API Key (for production use)

## Project Structure

```
src/main/java/com/hendisantika/
├── client/               # SendGrid client implementation
├── config/              # Configuration classes
├── controller/          # REST controllers
├── dto/                 # Data Transfer Objects
├── exception/           # Custom exceptions and handlers
├── message/             # Message handling utilities
├── service/             # Business logic
└── validator/           # Email validation

src/main/resources/
├── templates/           # Mustache email templates
└── application.properties

src/test/java/           # Unit and integration tests
```

## Configuration

Create or update `application.properties`:

```properties
server.servlet.context-path=/email
logging.level.root=INFO
sendgrid.key=${SENDGRID_API_KEY:YOUR_SENDGRID_API_KEY}
spring.mustache.prefix=classpath:/templates/
spring.mustache.suffix=.html
```

### Environment Variables

Set the SendGrid API key as an environment variable:

```bash
export SENDGRID_API_KEY=your_actual_sendgrid_api_key_here
```

## Build and Run

### Build the project

```bash
mvn clean install
```

### Run the application

```bash
mvn spring-boot:run
```

Or run the JAR directly:

```bash
java -jar target/springboot-sendgrid-greenmail-client.jar
```

The application will start on port 8080 with context path `/email`.

## API Endpoints

### Send Email

**Endpoint**: `POST /email/api/send`

**Request Body**:

```json
{
  "to": "recipient@example.com",
  "from": "sender@example.com",
  "subject": "Email Subject",
  "templateName": "email-demo-template",
  "templateParams": {
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
}
```

**Example using curl**:

```bash
curl -X POST http://localhost:8080/email/api/send \
  -H "Content-Type: application/json" \
  -d '{
    "to": "user@example.com",
    "from": "sender@example.com",
    "subject": "Test Email",
    "templateName": "email-demo-template",
    "templateParams": {
      "name": "John Doe",
      "email": "john.doe@example.com"
    }
  }'
```

**Response**:

```json
{
  "statusCode": 202,
  "body": "...",
  "headers": {
    ...
  }
}
```

## Email Templates

Email templates are stored in `src/main/resources/templates/` and use Mustache syntax.

Example template (`email-demo-template.html`):

```html
<!doctype html>
<html>
<body>
<h2>Hello, <span>{{name}}</span>!</h2>
<p>This is an example email sent to {{email}}.</p>
</body>
</html>
```

## Testing

The project includes unit and integration tests using GreenMail as a mock SMTP server.

Run tests:

```bash
mvn test
```

## Key Components

### EmailSendgridController

REST controller that handles email sending requests at `/api/send`.

### SendGridClient

Implements the SendGrid API integration for sending emails.

### TemplateService

Processes Mustache templates with dynamic parameters.

### EmailValidator

Validates email request data before sending.

## Error Handling

The application includes comprehensive error handling:

- Invalid email entries
- Template not found
- Template parsing errors
- Email connection exceptions

## Compatibility Notes

This version has been updated for compatibility with:

- Spring Boot 3.x (Jakarta EE instead of javax)
- Java 21
- Latest SendGrid Java SDK
- GreenMail 2.1.7

## Migration from Spring Boot 2.x

Key changes made for Spring Boot 3.x compatibility:

- Updated `javax.validation` to `jakarta.validation`
- Updated `javax.mail` to `jakarta.mail`
- Removed deprecated `SocketUtils` usage
- Updated SendGrid imports to use helpers package
- Fixed Lombok annotation processing configuration

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## License

This project is open source and available under the [MIT License](LICENSE).
